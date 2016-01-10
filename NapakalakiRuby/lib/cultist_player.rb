# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "BadConsequence.rb"
require_relative "Treasure.rb"
require_relative "Dice.rb"
require_relative "TreasureKind.rb"
require_relative "CombatResult.rb"
require_relative "CardDealer.rb"

module Napakalaki
  

class CultistPlayer < PLayer
  attr_accessor :myCultistCard
  
  @@total_pCultist = 0
  
  def initialize(player, cultist)
    
    super(player.name)
    copia(player)
    
    @muCultistCard = cultist
    @total_pCultist += 1
    
  end
  
  def shouldConvert
    return false
  end
  
  def getCombatLevel
    lvl = super.getCombatLevel
    lvl = ((lvl * 20)/100) + total_pCultist * myCultistCard.getGainedLevels
    return lvl
  end
  
  def getOponentLevel(m)
      retun m.getCombatLevelAgainstCultistPlayer
  end
  
  def giveMeATreasure
			return visibleTreasures.get(1+Random.rand(4))
	end
  def canYouGiveMeATreasure
    if !hiddenTreasures.empty? || !visibleTreasures.empty?
      return true
      end
    return false
  end
end
end