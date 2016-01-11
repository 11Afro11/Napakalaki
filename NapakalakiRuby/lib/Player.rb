# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
require_relative "BadConsequence.rb"
require_relative "Treasure.rb"
require_relative "Dice.rb"
require_relative "TreasureKind.rb"
require_relative "CombatResult.rb"
require_relative "CardDealer.rb"
require_relative "numeric_bad_consequence.rb"
module NapakalakiGame

	class Player
		attr_accessor :name, :level, :dead, :canSteal, :enemy, :hiddenTreasures, :visibleTreasures, :badStuff
		
		def initialize(name)
			@name = name
			@level = 1
			@dead = true
			@canSteal = true
			@enemy = nil
			@hiddenTreasures =Array.new
			@visibleTreasures = Array.new
			@badStuff = NumericBadConsequence.new("",0,0,0)
	    	@@maxLevel = 10
		end

		def copia(p)
			@name = p.name
			@level = p.level
			@dead = p.dead
			@canSteal = p.canSteal
			@enemy = p.enemy
			@hiddenTreasures =p.hiddenTreasures
			@visibleTreasures = p.visibleTreasures
			@badStuff = p.badStuff
		end

		#EXAMEN

		def setHiddenTreasures(tesoros)
			hiddenTreasures.clear
			tesoros.each do |t|
				hiddenTreasures << t
			end
		end

		#FINEXAMEN

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
			return @dead
		end

		def incrementLevels(lvl)
			@level = @level+lvl
			if(@level > 10)
				level = 10
			end
		end

		def decrementLevels(lvl)
			# @level = @level-lvl
			# if (@level < 1)
			# 	puts "teta"
			# 	level = 1
			# end
			puts "pene"
			if (lvl >= @level)
				@level = 1
			else
				@level = @level - lvl
			end
		end

		def setPendingBadConsequence(bad)
			@badStuff = bad
		end

		def applyPrize(monstruo)
			prize = monstruo.getPrize
			nlevels = prize.getLevels
			self.incrementLevels(nlevels)
			nTreasures = prize.getTreasures
			if nTreasures > 0
				dealer = CardDealer.instance
				i = 0
				while i < nTreasures
					treasure = dealer.nextTreasure()
					@hiddenTreasures<<treasure
					i = i+1
				end
			end
		end

		def applyBadConsequence(bc)
			# nlevels = bc.getLevels
		    self.decrementLevels(bc.getLevels)
		    pendingBad = bc.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
		    setPendingBadConsequence(pendingBad)
		end

	  	def canMakeTreasureVisible(t)
	    	result = false;
	    
	    	if @visibleTreasures.size() < 4
	      		tipo = t.getType;
	      
	      	if tipo == TreasureKind::ONEHAND
	        	if self.isTreasureKindInUse(TreasureKind::BOTHHANDS)
	          		result = false
	        	end
	      	else
	        	i = 0
	        	for m in @visibleTreasures
	          		if m.getType.equal?(TreasureKind::ONEHAND)
	            		i = i+1
	          		end
	        	end
	        	if i == 2
	          		result = false
	        	else
	          		result = true
	        	end
	      	end
	    	
	    	else
	      		result = !self.isTreasureKindInUse(tipo)
	    	end
	    	
	    	return result
	  	end
	  
	  
	  	def isTreasureKindInUse(tipo)
	    	result = false
	    	for m in self.visibleTreasures
	      		if tipo.equals(m.getType)
	        		return result = true
	      		end
	    	end
	    	return result
	  	end
	  
		def dieIfNoTreasures
			if hiddenTreasures.empty? && visibleTreasures.empty?
				return true 
	    	end
			return false
		end

		def validState
			validState = false
			if badStuff.isEmpty && hiddenTreasures.size <= 4
				validState = true
	    	end
			return validState
		end	

		def howManyVissibleTreasures
			return visibleTreasures.size()
		end

		def getLevel
			@level
		end

		def setEnemy(enemy)
			p = Player.new("")
		    p.copia(enemy)
		    @enemy = p
		end

		def haveStolen
			@canSteal = false
		end

		def canYouGiveMeATreasure
			if !hiddenTreasures.empty? || !visibleTreasures.empty?
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
	    	monsterLevel = self.getOponentLevel(m)
	    	if myLevel > monsterLevel
	      		self.applyPrize(m)
	      	if@level >= 10
	        	combatResult = CombatResult::WINGAME
	      	else
	        	combatResult = CombatResult::WIN
	      	end
	    	else
          if self.shoulConvert
            combatResult = CombatResult::LOSEANDCONVERT
          else
	      		combatResult = CombatResult::LOSE
	      		amIdead = m.getBadConsequence().getDeath();
	      		if(amIdead)
	        		@dead = true
	      		else
	        		bad = m.getBadConsequence()
	        		self.applyBadConsequence(bad)
	      		end
          end
	    	end
	    	return combatResult
	  	end
	  
		def makeTreasureVisible(t)
			canI = self.canMakeTreasureVisible(t)
			if canI
				visibleTreasures << t
				hiddenTreasures.delete(t)
			end
		end

		def discardVisibleTreasure(t)
			visibleTreasures.delete(t)
			if @badStuff != nil && !@badStuff.isEmpty
				@badStuff.substractVisibleTreasure(t)
			end
			dieIfNoTreasures()
		end

		def discardHiddenTreasure(t)
			hiddenTreasures.delete(t)
			if @badStuff != nil && !@badStuff.isEmpty
				@badStuff.substracthiddenTreasure(t)
			end
			dieIfNoTreasures()
		end

		def initTreasure
			dealer = CardDealer.instance
			dice = Dice.instance
			self.bringToLife()
			treasure = dealer.nextTreasure()
			hiddenTreasures << treasure
			number= dice.nextNumber()
			if number > 1
				treasure = dealer.nextTreasure()
				hiddenTreasures << treasure
			end
			if number == 6
				treasure = dealer.nextTreasure()
				hiddenTreasure << treasure
			end

		end

		def stealTreasure
			canI = self.canISteal()
			if canI
				canYou = @enemy.canYouGiveMeATreasure
				if canYou
					treasure = enemy.giveMeATreasure
					@hiddenTreasures<<treasure
					self.haveStolen()
					return treasure
				end
			else 
				return nil
			end
		end

		def giveMeATreasure
			return hiddenTreasures.get(1+Random.rand(4))
		end

		def canISteal
			return canSteal
		end

		def canYouGiveMeAtreasure
			return (!hiddenTreasures.empty? || !visibleTreasures.empty?)
		end

		def haveStolen
			canSteal = false
		end

		def discardAllTreasures
			for t in @visibleTreasuresx
				self.discardVsibleTreasure(t)
			end

			for t in @hiddenTreasures
				self.discardHiddenTreasure(t)
			end
		end

		def initTreasures(names)
			dealer = CardDealer.instance
			dice = Dice.instance
			self.bringToLife()
			treasure = dealer.nextTreasure()
			@hiddenTreasures<<(treasure)
			number = dice.nextNumber()
			if number > 1
				treasure = dealer.nextTreasure()
				@hiddenTreasures<<(treasure)
			end 
			if number == 0
				treasure = dealer.nextTreasure()
				@hiddenTreasures<<(treasure)
			end
		end
    
    def shouldConvert
      dice = Dice.instance
      
      if dice.nextNumber == 0
        return true
      else
        return false
      end
    end
      
    def getOponentLevel(m)
      retun m.getCombatLevel
    end

		def to_s
			"Nombre: #{@name}, Nivel:#{@level}"
		end

	end
end
