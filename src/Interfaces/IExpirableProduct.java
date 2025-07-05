package Interfaces;

import java.security.PublicKey;

public interface IExpirableProduct {
    public boolean IsExpired();
    public void ExpireIt();
}
