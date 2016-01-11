# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "BadConsequence.rb"
module NapakalakiGame
  class SpecificBadConsecuence < BadConsequence
    attr_accessor :specificHiddenTreasures, :specificVisibleTreasures
    
    def initialize(text, levels ,specificHiddenTreasures, specificVisibleTreasures)
      super(text, levels)
      @specificHiddenTreasures = specificHiddenTreasures
      @specificVisibleTreasures = specificVisibleTreasures
    end
    def substractVisibleTreasure(t)
      @specificVisibleTreasure.remove(t.getType)
    end
    
    def substractHiddenTreasure(t)
      @specificHiddenTreasure.remove(t.getType)
    end
    
    def adjustToFitTreasureLists(vt, ht)
          
      else
        if(!@specificVisibleTreasure.nil? || !@specificHiddenTreasure.nil?)
          visible = vt & @specificVisibleTreasure
          hidden = ht & @specificHiddenTreasure
          bd = BadConsequence.newLevelNumberOfTreasures(@text, @levels, visible, hidden)
        end
      end
      return bd        
    end
    
    def isEmpty
      empty = false
      if(@specificVisibleTreasures.empty? && @specificHiddenTreasures.empty?) then
        empty = true
      end
      return empty
    end
    
    def to_s
      "#{@text}"
    end
    end


