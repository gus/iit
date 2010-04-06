require 'fibers/consumer'

#
# ruby1.9 fibers/producer.rb
class Producer
  def initialize(name, consumer, consumables_to_create)
    @fiber = Fiber.new do
      consumables_to_create.times do |i|
        consumer.resume("#{name} - #{i}")
      end
    end
  end

  def produce!
    @fiber.resume
  end
end

consumer = Consumer.new
# Producer.new("happy", consumer, 5).produce!
# Producer.new("skidmark", consumer, 10).produce!
# Producer.new("dopey", consumer, 8).produce!

threads = []
threads << Thread.new { Producer.new("happy", consumer, 5).produce! }
threads << Thread.new { Producer.new("skidmark", consumer, 10).produce! }
threads << Thread.new { Producer.new("dopey", consumer, 8).produce! }

threads.each { |t| t.join } # Whoops
