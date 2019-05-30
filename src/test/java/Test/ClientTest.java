package Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

import com.tnt.bourse.controllers.ClientController;
import com.tnt.bourse.entities.Client;
import com.tnt.bourse.services.ClientService;

public class ClientTest {
	ClientController clientController =new ClientController();
	ClientService clientService =mock(ClientService.class);
	ArrayList<Client> list=new ArrayList<>();
	Client clt1=new Client ();
	ArrayList<Client> list1=new ArrayList<>();
	Client clt2=new Client ();

}
