# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "CardDealer"
require_relative "Player"
require "singleton"
module Napakalaki
	include Singleton

	def initPlayers(names)
		@players = Array.new
		names.each do |s|
			players<<Player.new(s)
		end

	end

	def nextPlayer
		total_p = @players.length

		if(@currentPlayer == nil) then
			next_index = rand(total_p)
		
	  end
  end
	def nextTurnAllowed
		if (@currentPlayer == nil) then
			allowed = true
		else
			allowed =@currentPlayer.valid_state
		end
		return allowed
		
	end

	def setEnemies
		total_players = @players.length
		enemie = rand(total_players)
		
	end

	def getInstance
		
	end

	def developCombat

	end

	def discardVisibleTreasures
		
	end

	def discardHiddenTreasures
		
	end

	def makeTreasuresVisible(treasure)
		
	end

	def initGame(players)
		
	end

	def getCurrentPlayer
		return @currentPlayer
		
	end

	def getCurrentMonster
		return @currentMonster
		
	end

	def nextTurn
		
	end

	def endOfGame
		return result = WINGAME
		
	end
end