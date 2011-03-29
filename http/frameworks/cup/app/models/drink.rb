class Drink < ActiveRecord::Base
  validates :amount, :inclusion => { :in => 0...10 }
end

