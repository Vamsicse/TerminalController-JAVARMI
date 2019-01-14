import java.rmi.*;
import java.io.*;
import java.rmi.server.*;
import java.util.*;
public interface intf extends Remote
{
        public byte[] downloadbyte(String s) throws RemoteException;
public char Alert(String msg) throws RemoteException;
public void shutdown() throws RemoteException;
public void restart() throws RemoteException;
public void logoff() throws RemoteException;
public LinkedList checkService() throws RemoteException;
public LinkedList search(String type, String drive) throws RemoteException;
public void taskkill(String pid) throws RemoteException;
public LinkedList systeminfo() throws RemoteException;
public StringBuffer downloadfile(String s) throws RemoteException;


}
