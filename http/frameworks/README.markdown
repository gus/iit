# A Rails App

Definitely check out the [Getting Started Guides](http://edgeguides.rubyonrails.org/getting_started.html)
if you are new to rails.

What I did to get the rails app running (make sure you have ruby 1.9.2 installed):

    > gem install --no-rdoc --no-ri rails bundler # install rails and bundler
    > rails new rails-example
    > cd rails-example
    > bundle install
    > rake db:create
    > rails server

Then open your browser to [http://localhost:3000](http://localhost:3000/).

Next I define a Shoes controller and index view and roll from there.

    > touch app/controllers/shoes_controller.rb
    > mkdir app/views/shoes
    > touch app/views/shoes/index.erb

Now, edit `config/routes.rb and add the following line near the top:

    resources :shoes

Create a migration for shoes and then the model

    > rails generate migration add_shoes
    > touch app/models/shoes.rb
    > # define migration
    > rake db:migrate

Etc etc etc

