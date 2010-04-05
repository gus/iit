require 'thread'

# Here you see that Java does give you some nice concurrency stuff out of the box
module Synchronizable
  def self.included(base)
    @@mutex = Mutex.new
    @@condition_variable = ConditionVariable.new
  end

  def synchronize(&block)
    @@mutex.synchronize(&block)
  end

  def wait
    @@condition_variable.wait(@@mutex)
  end

  def signal
    @@condition_variable.signal
  end

  def broadcast
    @@condition_variable.broadcast
  end
end
