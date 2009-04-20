package gus.synchronize;

public interface Account {
  public boolean withdraw(long amount);
  public long getBalance();
}