#encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
  class Monster
    attr_accessor :name, :combatLevel, :prize, :bc, :levelChangeAgainstCultistPlayer
    def initialize(name, combatLevel, prize, bc)
      @name = name
      @combatLevel = combatLevel
      @prize = prize
      @bc = bc
      @levelChangeAgainstCultistPlayer = 0
    end
    
    def initialize(name, combatLevel, prize, bc, lv)
      @name = name
      @combatLevel = combatLevel
      @prize = prize
      @bv = bc
      @levelChangeAgainstCultistPlayer = lv
    end
    
    def getName
      @name
    end
    
    def getCombatLevel
      @combatLevel
    end
    
    def getPrize
      @prize
    end
    
    def getBadConsequence
      @bc
    end
    
    def getCombatLevelAgainstCultistPlayer
      return getCombatLevel() + @levelChangeAgainstCultistPlayer
    end
    
    def to_s
      "Nombre: #{@name} Nivel: #{@combatLevel} Precio: #{@prize} Bad Consequence: #{@bc}"
    end
    
  end
end