#encoding: UTF-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
  class BadConsequence
    attr_accessor :text, :levels, :nVisibleTreasures, :nHiddenTreasures, :death, :tVisibleTreasures, :tHiddenTreasures
    def initialize(aText, someLevels = 0, someVisibleTreasures= 0, someHiddenTreasures = 0, someSpecificVisibleTreasures = Array.new, someSpecificHiddenTreasures = Array.new, deth = false) 
      @text = aText
      @levels = someLevels
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @tVisibleTreasures = someSpecificVisibleTreasures
      @tHiddenTreasures = someSpecificHiddenTreasures
      @death = deth
    end

    private_class_method :new

    def self.newLevelNumberOfTreasures(text, someLevels, someVisibleTreasures, someHiddenTreasures)
      new(text, someLevels, someVisibleTreasures, someHiddenTreasures)
    end
    
    def self.newLevelSpecificTreasures(text, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(text, someLevels, 0, 0, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
    end
    
    def self.newDeath(text)
      new(text, 0, 0, 0, Array.new, Array.new, true)
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
    
    def substractVisibleTreasure(t)
      self.specificVisibleTreasure.remove(t.getType)
    end
    
    def substractHiddenTreasure(t)
      self.specificHiddenTreasure.remove(t.getType)
    end
    
    def adjustToFitTreasureLists(vt, ht)
      if(@nHiddenTreasures != 0 || @nVisibleTreasures != 0)
        if(vt.size() <= @nVisibleTreasures)
          nv = vt.size()
        
        else
          nv = @nVissibleTreasures
        end
        if(ht.size() <= @nHiddenTreasures)
          nh = ht.size()
        else
          nh = @nHiddenTreasures
        end
        bd = BadConsequence.newLevelNumberOfTreasures(self.text, self.levels, nv, nh)
      
      else if(!self.specificVisibleTreasure.isEmpty() || !self.specificHiddenTreasure.isEmpty())
          visible = vt & specificVisibleTreasure
          hidden = ht & specificHiddenTreasure
          bd = BadConsequence.newLevelNumberOfTreasures(self.text, self.levels, visible, hidden)
      end
      return bd        
    end
    end
    
    def to_s
      "#{@text}"
    end 
    
  end
end