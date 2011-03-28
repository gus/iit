class Shoe < ActiveRecord::Base
  validates :name, :presence => true
  validates :size, :presence => true
  validates :color, :presence => true
  validates :description, :presence => true
end

