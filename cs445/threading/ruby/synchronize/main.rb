require 'synchronize/account'
require 'synchronize/safe_account'

#
# ruby synchronize/main.rb [safe|unsafe]

threads = []
if ARGV.first == "unsafe"
  account = Account.new(1000000)
  threads << Thread.new { MeanMachine.new("a", account, 125000).run }
  threads << Thread.new { MeanMachine.new("b", account, 250000).run }
elsif ARGV.first =="safe"
  account = SafeAccount.new(Account.new(1000000), Mutex.new) # Why are we creating the mutex here?
  threads << Thread.new { MeanMachine.new("a", account, 25000).run }
  threads << Thread.new { MeanMachine.new("b", account, 50000).run }
  threads << Thread.new { MeanMachine.new("c", account, 50000).run }
else
  puts "Whoops!"
end

threads.each { |t| t.join } # What if I don't do this
