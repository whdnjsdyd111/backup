package é��19_NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executors;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ��1_ServerExample extends Application {
	AsynchronousChannelGroup channelGroup;
	AsynchronousServerSocketChannel serverSocketChannel;
	List<Client> connections = new Vector<Client>();

	void startServer() {
		// ���� ���� �ڵ�
		try {
			channelGroup = AsynchronousChannelGroup.withFixedThreadPool(
					Runtime.getRuntime().availableProcessors(),
					Executors.defaultThreadFactory()
			);
			serverSocketChannel = AsynchronousServerSocketChannel.open(channelGroup);
			serverSocketChannel.bind(new InetSocketAddress(5001));
		} catch (Exception e) {
			if (serverSocketChannel.isOpen()) {
				stopServer();
			}
			return;
		}
		Platform.runLater(() -> {
			displayText("[���� ����]");
			btnStartStop.setText("stop");
		});
		
		serverSocketChannel.accept(null,
			new CompletionHandler<AsynchronousSocketChannel, Void>() {
			@Override
			public void completed(AsynchronousSocketChannel socketChannel, Void attachment) {
				try {
					String message = "[���� ����: " + socketChannel.getRemoteAddress() + ": " +
										Thread.currentThread()
							+ "]";
					Platform.runLater(() -> displayText(message));
				} catch (IOException e) {}

				Client client = new Client(socketChannel); // Client ��ü ����
				connections.add(client);
				Platform.runLater(() -> displayText("[���� ����: " + connections.size() + "]"));

				serverSocketChannel.accept(null, this); // accept() �ٽ� ȣ��
			}

			@Override
			public void failed(Throwable exc, Void attachment) {
				if (serverSocketChannel.isOpen()) {
					stopServer();
				}
			}
		}); // accept() �޼ҵ� ��
	} // startServer() �޼ҵ� ��

	void stopServer() {
		// ���� ���� �ڵ�
		try {
			connections.clear();
			if(channelGroup != null && !channelGroup.isShutdown()) {
				channelGroup.shutdownNow();		// �񵿱� ä�� �׷� ����(��� �񵿱� ä���� ����)
			}
			Platform.runLater( () -> {
				displayText("[���� ����]");
				btnStartStop.setText("start");
			});
		} catch (Exception e) {}
	}

	class Client {
		// ������ ��� �ڵ�
		AsynchronousSocketChannel socketChannel;

		Client(AsynchronousSocketChannel socketChannel) {
			this.socketChannel = socketChannel;
			receive();
		}

		void receive() {
			// ������ �ޱ� �ڵ�
			ByteBuffer byteBuffer = ByteBuffer.allocate(100);
			socketChannel.read(byteBuffer, byteBuffer,
				new CompletionHandler<Integer, ByteBuffer>() {
				@Override
				public void completed(Integer result, ByteBuffer attachment) {
					try {
						String message = "[��û ó��: " + socketChannel.getRemoteAddress() + ": " +
											Thread.currentThread().getName() + "]";
						Platform.runLater( () -> displayText(message) );
	
						attachment.flip();		// ���ڿ� ��ȯ
						Charset charset = Charset.forName("UTF-8");
						String data = charset.decode(attachment).toString();
	
						for(Client client : connections) {	// ��� Ŭ���̾�Ʈ���� ������
							client.send(data);	
						}
	
						ByteBuffer byteBuffer = ByteBuffer.allocate(100);
						socketChannel.read(byteBuffer, byteBuffer, this);	// �ٽ� ������ �б�
					} catch(Exception e) {}
				}
				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " + 
											socketChannel.getRemoteAddress() + ": " +
											Thread.currentThread().getName() + "]";
						Platform.runLater( () -> displayText(message) );
						connections.remove(Client.this);
						socketChannel.close();
					} catch (IOException e) {}
				}
			});
		}
		
		void send(String data) {
			// ������ ���� �ڵ�
			Charset charset = Charset.forName("UTF-8");
			ByteBuffer byteBuffer = charset.encode(data);
			socketChannel.write(byteBuffer, null,
				new CompletionHandler<Integer, Void>() {
				@Override
				public void completed(Integer result, Void attachment) {
				}
				@Override
				public void failed(Throwable exc, Void attachment) {
					try {
						String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " +
											socketChannel.getRemoteAddress() + ": " + 
											Thread.currentThread().getName() + "]";
						Platform.runLater( () -> displayText(message) );
						connections.remove(Client.this);
						socketChannel.close();
					} catch(IOException e) {}
				}
			});
		}
	}

	// UI �ڵ�
	TextArea txtDisplay;
	Button btnStartStop;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane root = new BorderPane();
		root.setPrefSize(500, 300);
	
		txtDisplay = new TextArea();
		txtDisplay.setEditable(false);
		BorderPane.setMargin(txtDisplay, new Insets(0, 0, 2, 0));
		root.setCenter(txtDisplay);
	
		btnStartStop = new Button("start");
		btnStartStop.setPrefHeight(30);
		btnStartStop.setMaxWidth(Double.MAX_VALUE);
		btnStartStop.setOnAction( e -> {		// start�� stop ��ư�� Ŭ������ �� �̺�Ʈ ó�� �ڵ�
			if(btnStartStop.getText().equals("start")) {
				startServer();
			} else if(btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});		//
		root.setBottom(btnStartStop);
	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("��3_app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest( event -> stopServer() );	// ������ ���� ��� �ݱ� ��ư�� Ŭ������ �� �̺�Ʈ ó�� �ڵ�
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
