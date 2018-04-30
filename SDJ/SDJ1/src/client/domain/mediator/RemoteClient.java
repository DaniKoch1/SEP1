package client.domain.mediator;

import server.domain.model.Member;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Observer;

public interface RemoteClient extends Observer {
    public ArrayList<Member> getAllMembers() throws RemoteException;

    public ArrayList<String> getListOfMembersWhoHasntPaid() throws RemoteException;
}