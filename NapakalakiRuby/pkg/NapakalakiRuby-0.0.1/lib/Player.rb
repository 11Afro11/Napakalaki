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
		nLevels = monstruo.getLevelsGained()
    self.incrementLevels(nlevels)
    nTreasures = monstruo.getTreasuresGained()
    if nTreasures > 0
      dealer = CardDealer.getInstance()
      i = 0
      while i < nTreasures
        treasure = dealer.nextTreasure()
        @hiddenTreasure.add(treasure)
      end
    end
	end

	def applyBadConsequence(bc)
		nlevels = bc.getLevels()
    self.decrementLevels(nLevels)
    pendingBad = b.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
    setPendingBadConsequence(pendingBad)
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
    return @hiddenTreasures
  end
  
  def getVisibleTreasures
    return @visibleTreasures
  end
  
  def combat(m)
    myLevel = self.getCombatLevel()
    monsterLevel = m.getCombatLevel()
    
    if myLevel > monsterLevel
      self.applyPrize(m)
      if@level >= 10
        combat = [CombatResult::WINGAME]
      else
        combat = [CombatResult::WIN]
      end
      
    else
      combat = [CombatResult::LOSE]
      amIdead = m.getBc().getDeath();
      if(amIdead)
        @dead = true
      else
        bad = m.getBc()
        self.applyBadConsequence(bad)
      end
      return combat
  end
  end
  
  def makeTreasureVisible(t)
    nappa = Napakalaki.getInstance()
    if self.canMakeTreasureVisible()
      nappa.makeTreasureVisible(t)
    end
  end
  
  def discardVisibleTreasure(t)
    nappa = Napakalaki.getInstance()
    nappa.discardVisibleTreasures(t)
  end
  
  def discardHiddenTreasure(t)
    nappa = Napakalaki.getInstance()
    nappa.discardHiddenTreasures(t)
  end
  
  def initTreasure
    dealer = CardDealer.getInstance()
    dice = Dice.getInstance()
    self.bringTiLife()
    treasure = dealer.nextTreasure()
    hiddenTreasires << treasure
    number= dice.nextNumber()
    if number > 1
      treasure = dealer.nextTreasure()
      hiddenTreasure << treasure
    end
    if number == 6
      treasure = dealer.nextTreasure()
      hiddenTreasure << treasure
    end
    
  end
  
  def stealTreasure
    canI = sel.canISteal()
    if canI
      canYou = @enemy.canYouGiveMeATreasure()
      if canYou
        treasure = enemy.giveMeATreasure()
        @hiddenTreasures.add(treasure)
        self.haveStolen()
        return treasure
      end
    end
    return null
  end
  
  def giveMeATreasure
    return hiddenTreasures.get(1+Random.rand(4))
  end
  
  def canIsteal
    return false
  end
  
  def canYouGiveMeAtreasure
    return (!hiddenTreasures.isEmpty() || !visibleTreasures.isEmpty())
  end
  
  def haveStolen
    return false
  end
  
  def discardAllTreasures
    for t in @visibleTreasures
      self.discardVsisibleTreasures(t)
    end
    
    for t in @hiddenTreasures
      self.discardHiddenTreasures(t)
    end
  end
  
  def initTreasures(names)
    dealer = CardDealer.getInstance()
    dice = Dice.getInstance()
    self.bringToLife()
    treasure = dealer.nextTreasure()
    @hiddenTreasures.add(treasure)
    number = dice.nextNumber()
    if number > 1
      treasure = dealer.nextTreasure()
      @hiddenTreasures.add(treasure)
    end 
    if number == 0
      treasure = dealer.nextTreasure()
      @hiddenTreasures.add(treasure)
    end
  end
  
  
  def to_s
    "Nombre: #{name}, Nivel:#{level}, Enemigo: #{enemy}"
  end
  
  end
end
