# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class BadConsequence
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures, death) 
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @tVisibleTreasures = someSpecificVisibleTreasures
    @tHiddenTreasures = someSpecificHiddenTreasures
    @death = death
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
    puts "#{text}"
  end
  
  private_class_method :new
  
  def self.LevelNumberOfTreasures(text, someLevels, someVisibleTreasures, someHiddenTreasures)
    initialize(text, someLevels, someVisibleTreasures, someHiddenTreasures, Array.new(), Array.new(), false)
  end
  
  def self.LevelSpecificTreasures(text, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    initialize(text, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
  end
  
  def self.Death(text)
    initialize(text, 0, 0, 0, Array.new(), Array.new(), true)
  end
  
  
end
