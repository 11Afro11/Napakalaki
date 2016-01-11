# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "BadConsequence.rb"
module NapakalakiGame
  class DeathBadConsequence < NumericBadConsequence
    att_accessor :death
  def initialize(text, levels ,nVisibleTreasures, nHiddenTreasures, death, specificHiddenTreasures, specificVisibleTreasures)
    super(text, levels ,nVisibleTreasures, nHiddenTreasures, death, specificHiddenTreasures, specificVisibleTreasures)
    newDeath(text,death)
  end
    end
  end

