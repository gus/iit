class DrinksController < ApplicationController
  def index
    @drinks = Drink.all
  end

  def new
    @drink = Drink.new
  end

  def create
    @drink = Drink.new(params[:drink])
    if @drink.save
      redirect_to drinks_path
    else
      render :action => "new"
    end
  end
end

