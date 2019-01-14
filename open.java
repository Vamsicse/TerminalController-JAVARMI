import java.util.*;
import java.io.*; 
import java.rmi.*; 
import java.rmi.server.*;
public class open 
 {
open(String path) 
{ 
try 
{ 
Runtime rt = Runtime.getRuntime(); 
Process proc = rt.exec(path); 
} 
catch(Exception e) 
{ 

} 
}

}  