class AddShoes < ActiveRecord::Migration
  def self.up
    create_table :shoes do |t|
      t.string :name
      t.integer :size
      t.string :color
      t.text :description

      t.timestamps
    end

  end

  def self.down
    drop_table :shoes
  end
end
