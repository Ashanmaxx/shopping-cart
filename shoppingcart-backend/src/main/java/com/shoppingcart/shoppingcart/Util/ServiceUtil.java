/**
 ***************************************************************
 * Copyright(C) 2017 AUXENTA INC.
 * All rights reserved.
 * <p>
 * THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF AUXENTA INC.
 * <p>
 * This copy of the Source Code is intended for AUXENTA INC's
 * internal use only and is intended for view by persons duly
 * authorized by the management of AUXENTA INC.
 * No part of this file may be reproduced or distributed in any form or by any
 * means without the written approval of the Management of AUXENTA INC.
 * <p>
 ***************************************************************
 */
package com.shoppingcart.shoppingcart.Util;

import com.shoppingcart.shoppingcart.dto.ResponseDto;
import org.springframework.stereotype.Service;

/**
 * Service Util for response generation.
 *
 * Created by prem on Oct 9, 2017.
 *
 */
@Service
public class ServiceUtil {
	public ResponseDto getExceptionServiceResponse(Exception e) {
		ResponseDto serviceResponseDto;
		serviceResponseDto = new ResponseDto();
		serviceResponseDto.setStatus(Boolean.FALSE);
		serviceResponseDto.setResponseDto(e.getMessage());
		serviceResponseDto.setErrorDescription(e.getMessage());
		return serviceResponseDto;
	}

	public ResponseDto getServiceResponse(Object responseObject) {
		ResponseDto serviceResponceDto;
		serviceResponceDto = new ResponseDto();
		serviceResponceDto.setStatus(Boolean.TRUE);
		serviceResponceDto.setResponseDto(responseObject);
		return serviceResponceDto;
	}

	public ResponseDto getErrorServiceResponse(Object responseObject) {
		ResponseDto serviceResponceDto;
		serviceResponceDto = new ResponseDto();
		serviceResponceDto.setStatus(Boolean.FALSE);
		serviceResponceDto.setResponseDto(responseObject);
		return serviceResponceDto;
	}

}
