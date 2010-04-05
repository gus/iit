class MeanMachine
  def initialize(name, account, withdraw_amount)
    @name, @account, @withdraw_amount = name, account, withdraw_amount
  end

  def run
    deducted, remaining = nil, nil
    while deducted != 0
      deducted, remaining = @account.withdraw!(@withdraw_amount)
      print_receipt "Deducted: #{deducted}" if deducted > 0
    end
    print_receipt "Done -"
  end
private
  def print_receipt(msg) puts "#{@name} - #{msg} Remaining: #{@account.balance}"; end
end # MeanMachine
