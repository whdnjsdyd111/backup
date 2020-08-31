package é��19_NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ��1_ServerExample extends Application {
	Selector selector;
	ServerSocketChannel serverSocketChannel;
	List<Client> connections = new Vector<Client>();
	
	void startServer() {
		// ���� ���� �ڵ�
		try {
			selector = Selector.open();	// Selector ����
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);	// �ͺ��ŷ���� ����
			serverSocketChannel.bind(new InetSocketAddress(5001));
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);	// Selector�� �۾� ������ ���
		} catch (Exception e) {
			if(serverSocketChannel.isOpen()) { stopServer(); }
			return;
		}
		
		Thread thread = new Thread() {	// ������ ����
			@Override
			public void run() {
				while(true) {
					try {
						int keyCount = selector.select();	// �۾� ó�� �غ� �� ä���� ���� ������ ���
						if(keyCount == 0) { continue; }
						Set<SelectionKey> selectedKeys = selector.selectedKeys();	// �۾� ó�� �غ� �� Ű�� ��� Set �÷������� ����
						Iterator<SelectionKey> iterator = selectedKeys.iterator();
						while(iterator.hasNext()) {
							SelectionKey selectionKey = iterator.next();
							if (selectionKey.isAcceptable()) {		// ���� ���� �۾��� ���
								accept(selectionKey);
							} else if (selectionKey.isReadable()) {	// �б� �۾��� ���
								Client client = (Client) selectionKey.attachment();
								client.receive(selectionKey);
							} else if (selectionKey.isWritable()) {	// ���� �۾��� ���
								Client client = (Client) selectionKey.attachment();
								client.send(selectionKey);
							}
							iterator.remove();		// ���õ� Ű�¿��� ó�� �Ϸ�� SeletionKey�� ����
						}
					} catch (Exception e) {
						if(serverSocketChannel.isOpen()) { stopServer(); }
						break;
					}
				}
			}
		};
		thread.start();
	
		Platform.runLater( () -> {
			displayText("[���� ����]");
			btnStartStop.setText("stop");
		});
	}
	
	void stopServer() {
		// ���� ���� �ڵ�
		try {
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socketChannel.close();	// ����� SocketChannel �ݱ�
				iterator.remove();
			}
			if(serverSocketChannel != null && serverSocketChannel.isOpen()) {
				serverSocketChannel.close();	// ServerSocketChannel �ݱ�
			}
			if(selector != null && selector.isOpen()) {
				selector.close();	// Selector �ݱ�
			}
			Platform.runLater( () -> {
				displayText("[���� ����]");
				btnStartStop.setText("start");
			});
		} catch (Exception e) {}

	}
	
	void accept(SelectionKey selectionKey) {
		// ���� ���� �ڵ�
		try {
			ServerSocketChannel serverSocketChannel =
				(ServerSocketChannel) selectionKey.channel();		// ServerSocketChannel ���
			SocketChannel socketChannel = serverSocketChannel.accept();	// ���� ����
			
			String message = "[���� ����: " + socketChannel.getRemoteAddress() + ": " +
				Thread.currentThread().getName() + "]";
			Platform.runLater( () -> displayText(message) );
		
			Client client = new Client(socketChannel);
			connections.add(client);

			Platform.runLater( () -> displayText("[���� ����: " + connections.size() + "]") );
		} catch(Exception e) {
			if(serverSocketChannel.isOpen()) { stopServer(); }
		}
	}
	
	class Client {
		// ������ ��� �ڵ�
		SocketChannel socketChannel;
		String sendData;	// Ŭ���̾�Ʈ�� ���� �����͸� �����ϴ� �ʵ�

		Client(SocketChannel socketChannel) {
			this.socketChannel = socketChannel;
			try {
			socketChannel.configureBlocking(false);
			SelectionKey selectionKey = socketChannel.register(selector,
																SelectionKey.OP_READ);		// �ͺ��ŷ���� �����ϰ� �б� �۾� �������� Selector�� ��Ͻ�Ŵ
			selectionKey.attach(this);		// SelectionKey�� �ڱ� �ڽ��� ÷�� ��ü�� ����
			} catch(Exception e) {}
		}

		void receive(SelectionKey selectionKey) {
			// ������ �ޱ� �ڵ� 
			try {
				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	
				// ������ ������ ���Ḧ ���� ��� �ڵ� IOException �߻�
				int byteCount = socketChannel.read(byteBuffer);		// ������ �ޱ�
		
				// ������ SocketChannel�� close() �޼ҵ带 ȣ���� ���
				if(byteCount == -1) {
					throw new IOException();
				}
		
				String message = "[��û ó��: " + socketChannel.getRemoteAddress() + ": " +
									Thread.currentThread().getName() + "]";
				Platform.runLater( () -> displayText(message) );
	
				byteBuffer.flip();		// ���ڿ� ��ȯ
				Charset charset = Charset.forName("UTF-8");
				String data = charset.decode(byteBuffer).toString();
	
				for(Client client : connections) {		// ��� Ŭ���̾�Ʈ���� ���ڿ��� �����ϴ� �ڵ�
					client.sendData = data;
					SelectionKey key = client.socketChannel.keyFor(selector);
					key.interestOps(SelectionKey.OP_WRITE);	// �۾� ���� ����
				}
				selector.wakeup();	// ����� �۾� ������ �����ϵ��� �ϱ� ���� Selector�� select() ���ŷ�� �����ǰ� �ٽ� �����ϵ��� �Ѵ�.
			} catch(Exception e) {
				try {
					connections.remove(this);
					String message = "[Ŭ���̾�Ʈ ��� �ȵ�: " + 
										socketChannel.getRemoteAddress() + ": " +
										Thread.currentThread().getName() + "]";
					Platform.runLater( () -> displayText(message) );
					socketChannel.close();
				} catch(IOException e2) {}
			}
		}
		
		void send(SelectionKey seletionKey) { 
			// ������ ���� �ڵ�
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
