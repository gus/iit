require 'worker/synchronizable'

#
# ruby worker/producer.rb
class Consumer
  include Synchronizable

  def initialize
    @queue = []
  end

  def consume!
    loop do
      consumable = synchronize { @queue.shift }
      if consumable
        puts "I'm a consumer of #{consumable}"
      else
        puts "I hate waiting :("
        synchronize { wait }
      end
    end
  end

  def add_consumable(consumable)
    synchronize do
      @queue.push(consumable)
      signal
    end
  end
end # Consumer
