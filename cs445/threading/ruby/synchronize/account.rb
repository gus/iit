require 'synchronize/mean_machine'

#
# ruby synchronize/main.rb unsafe
class Account
  attr_reader :balance
  
  def initialize(balance)
    @balance = balance
  end

  def withdraw!(amount)
    if amount <= balance
      # Sleeping to simulate some work being done
      sleep(0.005)
      @balance -= amount
      [amount, @balance]
    else
      [0, @balance]
    end
  end
end
