class MeanMachine
  def initialize(name, account, withdraw_amount)
    @name, @account, @withdraw_amount = name, account, withdraw_amount
  end

  def run
    deducted, remaining = nil, nil
    while deducted != 0
      deducted, remaining = @account.withdraw!(@withdraw_amount)
      puts "Deducted: #{deducted} Remaining: #{remaining}" if deducted > 0
    end
    puts "Done - Remaining: #{@account.balance}"
  end
end # MeanMachine
