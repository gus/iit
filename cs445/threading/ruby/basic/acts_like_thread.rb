#
# ruby basic/acts_like_thread.rb
class ActsLikeThread < Thread
  def initialize(message, sleep_time)
    @message = message
    @sleep_time = sleep_time

    super do
      loop do
        puts @message
        sleep(@sleep_time)
      end
    end
  end
end # ActsLikeThread

t1 = ActsLikeThread.new("Hello", 0.25);
t2 = ActsLikeThread.new("world", 0.5);

puts "Done starting threading"
sleep(5)
puts "Awake now"

t1.kill; t2.kill
