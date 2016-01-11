# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
require_relative 'BadConsequence.rb'


require_relative 'numeric_bad_consequence.rb'

class DeathBadConsequence < NumericBadConsequence
  def initialize(text)
    super(text, 0 ,0,0)
    @death = death
  end
  public_class_method :new
  attr_accessor :death
end
end

