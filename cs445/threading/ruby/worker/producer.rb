require 'worker/consumer'

#
# ruby worker/producer.rb
class Producer
  def initialize(name, consumer, consumables_to_create)
    @name, @consumer, @consumables_to_create = name, consumer, consumables_to_create
  end

  def produce!
    @consumables_to_create.times do |i|
      sleep((i % 2) / 1000)
      @consumer.add_consumable("#{@name} - #{i}")
    end
  end
end

consumer = Consumer.new
consumer_thread = Thread.new { consumer.consume! }

threads = []
threads << Thread.new { Producer.new("happy", consumer, 5).produce! }
threads << Thread.new { Producer.new("dopey", consumer, 8).produce! }
threads << Thread.new { Producer.new("skidmark", consumer, 10).produce! }

threads.each { |t| t.join }
# consumer_thread.join # deadlock
