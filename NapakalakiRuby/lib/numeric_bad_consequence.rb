# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "BadConsequence.rb"
module NapakalakiGame
  class NumericBadConsequence < BadConsequence
    attr_accessor :text, :levels, :nVisible, :nHidden
    
    def initialize(text, levels = 0, nVisible = 0, nHidden = 0)
        super(text, levels, nVisible, nHidden)
        
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
    end
  end

