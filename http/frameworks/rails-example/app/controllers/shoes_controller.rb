class ShoesController < ApplicationController
  # GET /shoes
  def index 
    @new_shoe = Shoe.new
    @shoes = Shoe.all
  end

  # GET /shoes/X
  def show
    @shoe = Shoe.find(params[:id])
  end

  # GET /shoes/new
  def new
    @shoe = Shoe.new
  end

  # POST /shoes
  def create
    @shoe = Shoe.new(params[:shoe])
    if @shoe.save
      redirect_to shoes_path
    else
      render :action => "new"
    end
  end

  # GET /shoes/X
  def edit
    @shoe = Shoe.find(params[:id])
  end

  # PUT /shoes/X
  def update
    @shoe = Shoe.find(params[:id])
    if @shoe.update_attributes(params[:shoe])
      redirect_to shoes_path
    else
      render :action => "edit"
    end
  end

  # DELETE /shoes/X
  def destroy
    @shoe = Shoe.find(params[:id])
    @shoe.destroy
    redirect_to shoes_path
  end
end

