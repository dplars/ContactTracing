/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemoteBeans;

import javax.ejb.Remote;

/**
 * @author dehan
 */
@Remote
public interface clientDBboonRemote {
     public long aantalBurgers();
     public long aantalContacten(int Type);
     public long aantalTesten();
}
