# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
module NapakalakiGame
require_relative 'BadConsequence.rb'


class SpecificBadConsequence < BadConsequence
  def initialize(text, levels , specificHiddenTreasures,  specificVisibleTreasures)
      super(text, levels)
     @specificHiddenTreasures = specificHiddenTreasures
     @specificVisibleTreasures = specificVisibleTreasures
  end
  public_class_method :new
  attr_accessor:specificHiddenTreasures, :specificVisibleTreasures
  
  ##########################################################
  ##########################################################
  def adjustToFitTreasureLists(v,h)
      nueva = nil
      sHidden = Array.new
      sVisible = Array.new
      
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
      
      aux = @specificVisibleTreasures
      i = 0
      while (i < v.length)
        found = false
        j = 0
        while(j < aux.length && found == false)
          if(v[i].getType() == aux[j])
            sVisible << aux[j]
            aux.delete(j)
            found = true
          end
          j = j+1
        end
        i = i+1
      end 
      nueva = SpecificBadConsequence.new("",@levels,sVisible,sHidden)
    
    return nueva
  end
  def isEmpty()
    b = false
    if(@specificVisibleTreasures.length == 0 && @specificHiddenTreasures.length == 0)
        b = true
      end
     return b
  end
  
  
  def substractVisibleTreasure(t)
    found = false
    i = 0
    while(i < @specificVisibleTreasures.length && found == false)
      if(@specificVisibleTreasures[i] == t.getType())
        found = true
        @specificVisibleTreasures.delete_at(i)
      end
      i = i + 1
    end
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
