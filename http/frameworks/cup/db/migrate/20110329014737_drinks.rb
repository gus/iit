class Drinks < ActiveRecord::Migration
  def self.up
    create_table :drinks do |t|
      t.integer :amount
      t.timestamps
    end
  end

  def self.down
    drop_table :drinks
  end
end
