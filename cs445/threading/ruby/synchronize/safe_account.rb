require 'thread'
require 'synchronize/account'
require 'synchronize/mean_machine'

#
# ruby synchronize/main.rb safe
# ruby1.9 synchronize/main.rb safe
class SafeAccount
  def initialize(account, semaphore)
    @account = account
    @semaphore = semaphore
  end

  def withdraw!(amount)
    @semaphore.synchronize { @account.withdraw!(amount) }
  end

  def balance
    @semaphore.synchronize { @account.balance }
  end
end
