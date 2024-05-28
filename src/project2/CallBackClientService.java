package project2;

/**
 * Client의 화면 부분에서 이벤트가 일어났을때 데이터를 가지고 오기 위한 콜백 인터페이스<br>
 * 
 * @author 김현아
 *
 */
public interface CallBackClientService {
	void clickConnectServerBtn(String ip, int port, String id);

	void clickSendMessageBtn(String messageText);

	void clickSendSecretMessageBtn(String msg);

	void clickMakeRoomBtn(String roomName);

	void clickOutRoomBtn(String roomName);

	void clickEnterRoomBtn(String roomName);
}
