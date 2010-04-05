#
# ruby basic/using_a_thread.rb
messenger = lambda do |message, sleep_time|
  loop do
    puts message
    sleep(sleep_time)
  end
end

t1 = Thread.new { messenger.call("Hello", 0.25) }
t2 = Thread.new { messenger.call("world", 0.5) }

puts "Done starting threading"
sleep(5)
puts "Awake now"

t1.kill; t2.kill
