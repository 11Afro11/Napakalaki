# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Monster
  def initialize(name, combatLevel)
    @name = name
    @combatLevel = combatLevel    
  end
  
  def initialize(name, combatLevel, prize, bc)
    @name = name
    @combatLevel = combatLevel
    @prize = prize
    @bc = bc
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
  
end
