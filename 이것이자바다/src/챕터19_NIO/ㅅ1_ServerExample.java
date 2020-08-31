package 챕터19_NIO;

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

public class ㅅ1_ServerExample extends Application {
	Selector selector;
	ServerSocketChannel serverSocketChannel;
	List<Client> connections = new Vector<Client>();
	
	void startServer() {
		// 서버 시작 코드
		try {
			selector = Selector.open();	// Selector 생성
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);	// 넌블로킹으로 설정
			serverSocketChannel.bind(new InetSocketAddress(5001));
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);	// Selector에 작업 유형을 등록
		} catch (Exception e) {
			if(serverSocketChannel.isOpen()) { stopServer(); }
			return;
		}
		
		Thread thread = new Thread() {	// 스레드 생성
			@Override
			public void run() {
				while(true) {
					try {
						int keyCount = selector.select();	// 작업 처리 준비가 된 채널이 있을 때까지 대기
						if(keyCount == 0) { continue; }
						Set<SelectionKey> selectedKeys = selector.selectedKeys();	// 작업 처리 준비가 된 키를 얻고 Set 컬렉션으로 리턴
						Iterator<SelectionKey> iterator = selectedKeys.iterator();
						while(iterator.hasNext()) {
							SelectionKey selectionKey = iterator.next();
							if (selectionKey.isAcceptable()) {		// 연결 수라 작업일 경우
								accept(selectionKey);
							} else if (selectionKey.isReadable()) {	// 읽기 작업일 경우
								Client client = (Client) selectionKey.attachment();
								client.receive(selectionKey);
							} else if (selectionKey.isWritable()) {	// 쓰기 작업일 경우
								Client client = (Client) selectionKey.attachment();
								client.send(selectionKey);
							}
							iterator.remove();		// 선택된 키셋에서 처리 완료된 SeletionKey를 제거
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
			displayText("[서버 시작]");
			btnStartStop.setText("stop");
		});
	}
	
	void stopServer() {
		// 서버 종료 코드
		try {
			Iterator<Client> iterator = connections.iterator();
			while(iterator.hasNext()) {
				Client client = iterator.next();
				client.socketChannel.close();	// 연결된 SocketChannel 닫기
				iterator.remove();
			}
			if(serverSocketChannel != null && serverSocketChannel.isOpen()) {
				serverSocketChannel.close();	// ServerSocketChannel 닫기
			}
			if(selector != null && selector.isOpen()) {
				selector.close();	// Selector 닫기
			}
			Platform.runLater( () -> {
				displayText("[서버 멈춤]");
				btnStartStop.setText("start");
			});
		} catch (Exception e) {}

	}
	
	void accept(SelectionKey selectionKey) {
		// 연결 수락 코드
		try {
			ServerSocketChannel serverSocketChannel =
				(ServerSocketChannel) selectionKey.channel();		// ServerSocketChannel 얻기
			SocketChannel socketChannel = serverSocketChannel.accept();	// 연결 수락
			
			String message = "[연결 수락: " + socketChannel.getRemoteAddress() + ": " +
				Thread.currentThread().getName() + "]";
			Platform.runLater( () -> displayText(message) );
		
			Client client = new Client(socketChannel);
			connections.add(client);

			Platform.runLater( () -> displayText("[연결 개수: " + connections.size() + "]") );
		} catch(Exception e) {
			if(serverSocketChannel.isOpen()) { stopServer(); }
		}
	}
	
	class Client {
		// 데이터 통신 코드
		SocketChannel socketChannel;
		String sendData;	// 클라이언트로 보낼 데이터를 저장하는 필드

		Client(SocketChannel socketChannel) {
			this.socketChannel = socketChannel;
			try {
			socketChannel.configureBlocking(false);
			SelectionKey selectionKey = socketChannel.register(selector,
																SelectionKey.OP_READ);		// 넌블로킹으로 설정하고 읽기 작업 유형으로 Selector에 등록시킴
			selectionKey.attach(this);		// SelectionKey에 자기 자신을 첨부 객체로 저장
			} catch(Exception e) {}
		}

		void receive(SelectionKey selectionKey) {
			// 데이터 받기 코드 
			try {
				ByteBuffer byteBuffer = ByteBuffer.allocate(100);
	
				// 상대방이 비정상 종료를 했을 경우 자동 IOException 발생
				int byteCount = socketChannel.read(byteBuffer);		// 데이터 받기
		
				// 상대방이 SocketChannel의 close() 메소드를 호출할 경우
				if(byteCount == -1) {
					throw new IOException();
				}
		
				String message = "[요청 처리: " + socketChannel.getRemoteAddress() + ": " +
									Thread.currentThread().getName() + "]";
				Platform.runLater( () -> displayText(message) );
	
				byteBuffer.flip();		// 문자열 변환
				Charset charset = Charset.forName("UTF-8");
				String data = charset.decode(byteBuffer).toString();
	
				for(Client client : connections) {		// 모든 클라이언트에게 문자열을 전송하는 코드
					client.sendData = data;
					SelectionKey key = client.socketChannel.keyFor(selector);
					key.interestOps(SelectionKey.OP_WRITE);	// 작업 유형 변경
				}
				selector.wakeup();	// 변경된 작업 유형을 감지하도록 하기 위해 Selector의 select() 블로킹을 해제되고 다시 실행하도록 한다.
			} catch(Exception e) {
				try {
					connections.remove(this);
					String message = "[클라이언트 통신 안됨: " + 
										socketChannel.getRemoteAddress() + ": " +
										Thread.currentThread().getName() + "]";
					Platform.runLater( () -> displayText(message) );
					socketChannel.close();
				} catch(IOException e2) {}
			}
		}
		
		void send(SelectionKey seletionKey) { 
			// 데이터 전송 코드
		}
	}
	
	// UI 코드
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
		btnStartStop.setOnAction( e -> {		// start와 stop 버튼을 클릭했을 때 이벤트 처리 코드
			if(btnStartStop.getText().equals("start")) {
				startServer();
			} else if(btnStartStop.getText().equals("stop")) {
				stopServer();
			}
		});		//
		root.setBottom(btnStartStop);
	
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("ㅅ3_app.css").toString());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Server");
		primaryStage.setOnCloseRequest( event -> stopServer() );	// 윈도우 우측 상단 닫기 버튼을 클릭했을 때 이벤트 처리 코드
		primaryStage.show();
	}
	
	void displayText(String text) {
		txtDisplay.appendText(text + "\n");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
