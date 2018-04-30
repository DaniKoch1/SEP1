package server.domain.mediator;

import server.domain.model.Member;
import client.domain.mediator.RemoteClient;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Server extends UnicastRemoteObject implements ServerManager {

	private static final long serialVersionUID = 1L;
	private ModelManager manager;

	public Server(ModelManager manager) throws RemoteException {
		super();
		this.manager = manager;
	}

	@Override
	public ArrayList<Member> getAllMembers() throws RemoteException {
		return manager.getAllMembers();
	}

	@Override
	public ArrayList<String> getListOfMembersWhoHasntPaid() throws RemoteException {
		return manager.getMemberList().getListOfEmailsWhoHasntPaid();
	}

	@Override
	public void registerObserver(RemoteClient observer) throws RemoteException {
		manager.registerObserver(observer);
	}


}