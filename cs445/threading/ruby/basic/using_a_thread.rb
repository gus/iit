#
# ruby basic/using_a_thread.rb
messager = lambda do |message, sleep_time|
  loop do
    puts message
    sleep(sleep_time)
  end
end

t1 = Thread.new { messager.call("Hello", 0.25) }
t2 = Thread.new { messager.call("world", 0.5) }

puts "Done starting threading"
sleep(5)
puts "Awake now"

t1.kill; t2.kill
