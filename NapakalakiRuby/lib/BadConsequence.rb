# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
  def initialize(text, levels, nVisibleTreasures, nHiddenTreasures)
    @text = text
    @levels = levels
    @nhiddenTreasures = nHiddenTreasures
    @nVisibleTreasures = nVisibleTreasures    
  end
  def initialize(text)
    @text = text
    @death = true
  end
  def initialize(text, levels, tVisible, tHidden)
    @text = text
    @levels = levels
    @tVisible = tVisible
    @tHidden = tHidden
  end
  
  def getText
    @text
  end
  
  def getLevels
    @levels
  end
  
  def getNVisibleTreasures
    @nVisibleTreasures
  end
  
  def getNHiddenTreasures
    @nHiddenTreasures
  end
  
  def getTvisibleTreasures
    @tVisibleTreasures
  end
  
  def getThiddenTreasures
    @tHiddenTreasures
  end
  
  def getDeath
    @death
  end
  
  def to_s
    
  end
  
end
