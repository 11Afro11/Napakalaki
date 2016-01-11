# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "BadConsequence.rb"
module NapakalakiGame
  class SpecificBadConsecuence < BadConsequence
    attr_accessor :text, :levels, :nVisible, :nHidden, :death, :specificHiddenTreasures, :specificVisibleTreasures
    
    def initialize(text, levels ,nVisibleTreasures, nHiddenTreasures, death, specificHiddenTreasures, specificVisibleTreasures)
      super(text, levels ,nVisibleTreasures, nHiddenTreasures, death, specificHiddenTreasures, specificVisibleTreasures)
      newLevelSpecificTreasures(text, levels, nVisibleTreasures, nHiddenTreasures)
    end
    def substractVisibleTreasure(t)
      @tVisibleTreasure.remove(t.getType)
    end
    
    def substractHiddenTreasure(t)
      @tHiddenTreasure.remove(t.getType)
    end
    
    def adjustToFitTreasureLists(vt, ht)
    	bd = BadConsequence.newLevelNumberOfTreasures("", 0,0,0)
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
        bd = BadConsequence.newLevelNumberOfTreasures(@text, @levels, nv, nh)
      
      else
        if(!@tVisibleTreasure.nil? || !@tHiddenTreasure.nil?)
          visible = vt & @specificVisibleTreasure
          hidden = ht & @specificHiddenTreasure
          bd = BadConsequence.newLevelNumberOfTreasures(@text, @levels, visible, hidden)
        end
      end
      return bd        
    end
    
    def to_s
      "#{@text}"
    end
    end
  end

