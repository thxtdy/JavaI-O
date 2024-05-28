package project2;

/**
 * 서버측과 클라이언트측 둘 사이의 기능 인터페이스
 * 
 * @author 김현아
 *
 */
public interface ProtocolImpl {
	void chatting();

	void secretMessage();

	void makeRoom();

	void madeRoom();

	void newRoom();

	void outRoom();

	void enterRoom();

	void newUser();

	void connectedUser();
}
