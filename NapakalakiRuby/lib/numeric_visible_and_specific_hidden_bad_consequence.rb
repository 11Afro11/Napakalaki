# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'BadConsequence.rb'
module NapakalakiGame
class NumericVisibleAndSpecificHiddenBadConsequence < BadConsequence
  def initialize(text, levels,nVisibleTreasures,specificHiddenTreasures )
    super(text, levels )
    @nVisibleTreasures = nVisibleTreasures
    @specificHiddenTreasures = specificHiddenTreasures
  end
  public_class_method :new
  #########################################################
  ########################################################
  attr_accessor:nVisibleTreasures,:specifficHiddenTreasures
  
  def adjustToFitTreasureLists(v,h)
    nueva = nil
    sHidden = Array.new
    if(@nVisibleTreasures > 0)
      if(v.length < @nVisibleTreasures)
        nVisibleTreasuresNueva = v.length
      else
        nVisibleTreasuresNueva = @nVisibleTreasures
      end
      
      aux = Array.new
      aux = @specificHiddenTreasures
      i = 0
      while (i < h.length)
        found = false
        j = 0
        while(j < aux.length && found == false)
          if(h[i].getType() == aux[j])
            sHidden << aux[j]
            aux.delete(j)
            found = true
          end
          j = j + 1
        end
        i = i + 1
      end
      
      nueva = NumericVisibleAndSpecificHiddenBadConsequence.new("",@levels,nVisibleTreasuresNueva,sHidden)
    

    end
    return nueva
  end
  
  def isEmpty()
    b = false
    if(@nVisibleTreasures == 0 && @specificHiddenTreasures.length == 0)
        b = true
      end
     return b
  end
  
  
  def substractVisibleTreasure(t)
    @nVisibleTreasures = @nVisibleTreasures -1
  end
  
  def substractHiddenTreasures(t)
    found = false
    i = 0
    while(i < @specificHiddenTreasures.length && found == false)
      if(@specificHiddenTreasures[i] == t.getType())
        found = true
        @specificHiddenTreasures.delete_at(i)
      end
      i = i + 1
    end
  end
end
end
