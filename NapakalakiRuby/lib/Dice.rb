# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  require "singleton"
	class Dice
		include Singleton
    

		def nextNumber
			r = Random.rand(1...6)
			return r
		end
    
    
  end
  
end
  

