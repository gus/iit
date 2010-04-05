#
# ruby1.9 fibers/producer.rb
class Consumer

  def initialize
    @fiber = Fiber.new do
      loop do
        if consumable = Fiber.yield
          puts "I'm a consumer of #{consumable}"
        else
          puts "I hate waiting :("
        end
      end
    end
    @fiber.resume
  end

  def resume(*args)
    @fiber.resume(*args)
  end

end # Consumer
