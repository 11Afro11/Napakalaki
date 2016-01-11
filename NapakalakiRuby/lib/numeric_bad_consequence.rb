# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
require_relative 'BadConsequence.rb'

class NumericBadConsequence < BadConsequence
  def initialize(text, levels,nVisibleTreasures,nHiddenTreasures )
    super(text, levels )
    @nVisibleTreasures = nVisibleTreasures
    @nHiddenTreasures = nHiddenTreasures
  end
  public_class_method :new
  #########################################################
  ########################################################
  attr_accessor:nVisibleTreasures,:nHiddenTreasures
  def adjustToFitTreasureLists(v,h)
    nueva = nil
    if(@nVisibleTreasures > 0 || @nHiddenTreasures > 0)
      if(v.length < @nVisibleTreasures)
        nVisibleTreasuresNueva = v.length
      else
        nVisibleTreasuresNueva = @nVisibleTreasures
      end
      
      if(h.length < @nHiddenTreasures)
        nHiddenTreasuresNueva = h.length
      else
        nHiddenTreasuresNueva = @nHiddenTreasures
      end
      
      nueva = NumericBadConsequence.new("",@levels,nVisibleTreasuresNueva,nHiddenTreasuresNueva)
    

    end
    return nueva
  end
  def isEmpty()
      b = false
    if(@nVisibleTreasures == 0 && @nHiddenTreasures == 0)
      if(@specificVisibleTreasures.length == 0 && @specificHiddenTreasures.length == 0)
        b = true
      end
    end
    return b
  end
  def substractHiddenTreasure()
    
  end
  def discardVisibleTreasure(treasure)
    
  end
  
end
end
