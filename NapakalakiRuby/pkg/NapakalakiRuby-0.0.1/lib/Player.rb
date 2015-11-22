# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

class Prize
	attr_accessor :name, :level, :dead, :canSteal, :enemy, :hiddenTreasures, :visibleTreasures, :badStuff
	def initialize(name, level, dead, canSteal, enemy, hiddenTreasures, visibleTreasures, badStuff)
		@name = name
		@level = level
		@dead = dead
		@canSteal = canSteal
		@enemy = enemy
		@hiddenTreasures = hiddenTreasures
		@visibleTreasures = visibleTreasures
		@badStuff = badStuff
    @@maxLevel = 10
	end


	def getName
		@name
	end

	def bringToLife
		@dead = false
	end
  
  def getCombatLevel
    lvl = 0
    
    @visibleTreasures.each do |t|
      lvl += t.getBonus()
    end
    return lvl
  end

	def isDead
		@dead
	end

	def incrementLevels(lvl)
		@levels = @levels + lvl
	end

	def decrementLevels(lvl)
		@levels = @levels - lvl
	end

	def setPendingBadConsequence(bad)
		@badStuff = bad
	end

	def applyPrize(monstruo)
		@level = @level + monstruo.getPrize().getLevel()
	end

	def applyBadConsequence(monstruo)
		@level = @level - monstruo.getBc().getLevel()
	end

  def canMakeTreasureVisible(t)
    result = false;
    
    if self.visibleTreasures.size() < 4
      tipo = t.getType;
      
      if type == ONEHAND
        if isTreasureKindInUse(BOOTHHANDS)
          result = false
        end
      else
        i = 0
        for m in self.visibleTreasures
          if m.getType.equals(ONEHAND)
            i = i+1
          end
        end
        if i == 2
          result = false
        
        else
          result = true
      end
        
      end
      else if
          result = !isTreasureKindInUse(tipo)
      end
    end
    return result
  end
  
  
  def isTreasureKindInUse(tipo)
    result = false
    for m in self.visibleTreasures
      if tipo.equals(m.getType)
        return true
      end
    end
    return false
  end
  
	def dieIfNoTreasures
		if hiddenTreasures.isEmpty() && visibleTreasures.isEmpty()
			return true 
    end
		return false
	end

	def validState
		if badStuff.isEmpty() && hiddenTreasures.size <= 4
			return true
    end
		return false
	end	

	def howManyVissibleTreasures
		return visibleTreasures.size()
	end

	def getLevel
		@level
	end

	def setEnemy(enemy)
		@enemy = enemy
	end

	def haveStolen
		@canSteal = false
	end

	def canYouGiveMeATreasure
		if !hiddenTreasures.isEmpty() || !visibleTreasures.isEmpty()
			return true
    end
		return false
	end
  
  def getHiddenTreasures
    return null
  end
  
  def getVisibleTreasures
    return null
  end
  
  def combat(m)
    return null
  end
  
  def makeTreasureVisible
  end
  
  def discardVisibleTreasure
  end
  
  def discardHiddenTreasure
  end
  
  def initTreasure
  end
  
  def stealTreasure
    return null
  end
  
  def giveMeATreasure
    return null
  end
  
  def canIsteal
    return false
  end
  
  def canYouGiveMeAtreasure
    return false
  end
  
  def haveStolen
    return false
  end
  
  def discardAllTreasures
  end
  
  def to_s
    "Nombre: #{name}, Nivel:#{level}, Enemigo: #{enemy}"
  end
  
  end
end
