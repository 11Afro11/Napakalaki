# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "BadConsequence.rb"
module NapakalakiGame
  class NumericBadConsequence < BadConsequence
    attr_accessor :numericHiddenTreasures, :numericVisibleTreasures
    
    def initialize(text, levels ,numericHiddenTreasures, numericVisibleTreasures)
      super(text, levels)
      @numericHiddenTreasures = numericHiddenTreasures
      @numericVisibleTreasures = numericVisibleTreasures
    end
    def substractVisibleTreasure(t)
      @numericVisibleTreasure = @numericVisibleTreasures -1
    end
    
    def substractHiddenTreasure(t)
      @numericHiddenTreasure = @numericHiddenTreasures -1
    end
    
    def adjustToFitTreasureLists(vt, ht)
        if vt > numericVisibleTreasures then
          nv = numericVisibleTreasures
        else 
          nv = vt
        end
        if ht > numericHiddenTreasures then
          nh = numericHiddenTreasures
        else
          nh = ht
        end
        bd = BadConsequence.newLevelNumberOfTreasures(@text, @levels, nv, nh)
      return bd        
    end
    
    def isEmpty
      empty = false
      if(@numericVisibleTreasures == 0 && @numericHiddenTreasures == 0) then
        empty = true
      end
      return empty
    end
    
    def to_s
      "#{@text}"
    end
    end
end

