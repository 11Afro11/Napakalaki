# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Prize
  def initialize(treasures, levels)
    @treasures = treasures
    @levels = levels
  end
  
  def setTreasures(treasure)
    @treasures = treasure    
  end
  
  def setLevels(level)
    @levels = level
  end
  
  def getLevels
    @levels
  end
  
  def getTreasures
    @treasures
  end
  
  def to_s
    "Nivel: #{@levels} Tesoros: #{@treasures}\n"
  end
  
  
  
end
